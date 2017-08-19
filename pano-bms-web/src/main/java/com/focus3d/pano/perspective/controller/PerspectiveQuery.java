package com.focus3d.pano.perspective.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.focus3d.pano.admin.service.IPerspectiveService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.ProductRelevance;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProduct;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProductModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveLayerModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveViewModel;
import com.focus3d.pano.usersside.service.ProductRelevanceService;
import com.focustech.cief.filemanage.client.api.IFileReadClient;
import com.focustech.cief.filemanage.client.constant.FileAttributeEnum;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/perspective")
public class PerspectiveQuery extends BaseController {
	@Autowired
	IPerspectiveService _service;

	@Autowired
	private IFileReadClient client;

	@Autowired
	private ProductRelevanceService productRelevanceService;

	/**
	 * @param map
	 * @param request
	 * @return
	 */
	// 查询户型空间信息
	@RequestMapping("query")
	public String QueryInfo(PanoPerspectiveViewModel model, ModelMap map) {
		List<Map<String, Object>> list;
		try {
			list = _service.QuerySpace(model.getHouseStyleSn());
			String data = JsonUtils.arrayToJson(list.toArray());
			map.put("house_style_sn", model.getHouseStyleSn());
			map.put("space", data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/perspective/Perspective";
	}

	// 查询空间视角信息
	@RequestMapping("viewQuery")
	public void QueryViewInfo(HttpServletResponse response,
			PanoPerspectiveViewModel model) {
		try {
			List<PanoPerspectiveViewModel> list = _service.QueryViewInfo(model);
			ajaxOutput(response, JsonUtils.arrayToJson(list.toArray()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("QueryViewProducts")
	public void QueryViewProducts(HttpServletResponse response,
			PanoPerspectiveViewModel model) {
		try {
			LinkedHashMap<String, Object> space = new LinkedHashMap<String, Object>();

			List<LinkedHashMap<String, Object>> list = _service
					.QueryViewAllProductInfo(model);
			for (LinkedHashMap<String, Object> map : list) {
				if (map.get("viewMap") != null) {
					Long viewMapKey = Long.parseLong(map.get("viewMap")
							.toString());

					Map<String, String> viewMapFile = client
							.getFile(viewMapKey);

					map.put("viewMapUrl", viewMapFile
							.get(FileAttributeEnum.VISIT_ADDR.name()));
					map.put("viewMapWidth",
							viewMapFile.get(FileAttributeEnum.WIDTH.name()));
					map.put("viewMapHeight",
							viewMapFile.get(FileAttributeEnum.HEIGHT.name()));
					map.put("viewMapId", EncryptUtil.encode(viewMapKey));
				}

				if (map.get("elementMap") != null) {
					Long elementMapKey = Long.parseLong(map.get("elementMap")
							.toString());

					Map<String, String> elementMapFile = client
							.getFile(elementMapKey);

					map.put("elementMapUrl", elementMapFile
							.get(FileAttributeEnum.VISIT_ADDR.name()));
					map.put("elementMapWidth",
							elementMapFile.get(FileAttributeEnum.WIDTH.name()));
					map.put("elementMapHeight",
							elementMapFile.get(FileAttributeEnum.HEIGHT.name()));
					map.put("elementMapId", EncryptUtil.encode(elementMapKey));
				}
			}
			/*
			 * for (LinkedHashMap<String, Object> map : list) {
			 * LinkedHashMap<String, Object> view; LinkedHashMap<String, Object>
			 * view_child;
			 * 
			 * String viewId = map.get("viewId").toString();
			 * 
			 * if (space.containsKey(viewId)) { view = (LinkedHashMap<String,
			 * Object>)space.get(viewId); view_child = (LinkedHashMap<String,
			 * Object>)view.get("layer"); } else { view = new
			 * LinkedHashMap<String, Object>(); space.put(viewId, view);
			 * 
			 * view.put("id", viewId); view.put("name",
			 * map.get("viewName").toString());
			 * 
			 * Long mapKey = Long.valueOf(map.get("viewMap").toString());
			 * 
			 * view.put("mapid", EncryptUtil.encode(mapKey));
			 * 
			 * view.put("url", client.getFile(mapKey,
			 * FileAttributeEnum.VISIT_ADDR)); view.put("width",
			 * client.getFile(mapKey, FileAttributeEnum.WIDTH));
			 * view.put("height", client.getFile(mapKey,
			 * FileAttributeEnum.HEIGHT)); view_child = new
			 * LinkedHashMap<String, Object>(); view.put("layer", view_child); }
			 * 
			 * Object _layerId = map.get("layerId"); if (_layerId != null) {
			 * String layerId = _layerId.toString(); LinkedHashMap<String,
			 * Object> layer; LinkedHashMap<String, Object> layer_child; if
			 * (view_child.containsKey(layerId)) { layer =
			 * (LinkedHashMap<String, Object>)view_child.get(layerId);
			 * layer_child = (LinkedHashMap<String,
			 * Object>)layer.get("element"); } else { layer = new
			 * LinkedHashMap<String, Object>(); view_child.put(layerId, layer);
			 * 
			 * layer.put("id", layerId); layer.put("name",
			 * map.get("layerName").toString()); layer.put("viewSn", viewId);
			 * layer.put("layerOrder",map.get("layerOrder").toString());
			 * 
			 * layer_child = new LinkedHashMap<String, Object>();
			 * layer.put("element", layer_child); }
			 * 
			 * Object _elementId = map.get("elementId"); if (_elementId != null)
			 * { String elementId = _elementId.toString(); LinkedHashMap<String,
			 * Object> element = new LinkedHashMap<String, Object>();
			 * layer_child.put(elementId, element);
			 * 
			 * element.put("elementId", _elementId);
			 * element.put("elementName",map.get("elementName").toString());
			 * element.put("elementOrder",map.get("elementOrder").toString());
			 * 
			 * if(map.get("elementMap")!=null){ Long element_mapKey =
			 * Long.valueOf(map.get("elementMap").toString());
			 * 
			 * Map<String,String> element_map = client.getFile(element_mapKey);
			 * 
			 * element.put("url",element_map.get(FileAttributeEnum.VISIT_ADDR.name
			 * ()));
			 * element.put("width",element_map.get(FileAttributeEnum.WIDTH.
			 * name()));
			 * element.put("height",element_map.get(FileAttributeEnum.HEIGHT
			 * .name())); element.put("position",
			 * map.get("position").toString()); element.put("scale",
			 * map.get("scale").toString()); } } } } String value =
			 * JsonUtils.mapToJson(space);
			 */
			String value = JsonUtils.arrayToJson(list.toArray());
			ajaxOutput(response, JsonUtils.arrayToJson(list.toArray()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("queryElement")
	public void QueryElement(HttpServletResponse response,
			PanoPerspectiveElementModel model) {
		try {
			List<Map<String, Object>> list = _service.QueryElement(model);
			JSONArray array = new JSONArray();

			for (Map<String, Object> child : list) {
				JSONObject json = new JSONObject();
				json.put("elementId", child.get("id").toString());
				json.put("name", child.get("name").toString());
				json.put("packageTypeSn", child.get("packageTypeSn").toString());
				json.put("elementOrder", child.get("elementOrder").toString());
				String elementProductSn = child.get("elementProductSn") != null ? child
						.get("elementProductSn").toString() : "";
				json.put("elementProductSn", elementProductSn);
				json.put("layerSn", child.get("layerSn").toString());

				if (child.get("mapid") != null) {
					Long mapid = Long.parseLong(child.get("mapid").toString());
					Map<String, String> map = client.getFile(mapid);
					json.put("url",
							map.get(FileAttributeEnum.VISIT_ADDR.name()));
					json.put("width", map.get(FileAttributeEnum.WIDTH.name()));
					json.put("height", map.get(FileAttributeEnum.HEIGHT.name()));
					json.put("position", child.get("position").toString());
					json.put("scale", child.get("scale").toString());
				}

				array.add(json);
			}

			ajaxOutput(response, array.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("queryElementProduct")
	public void QueryElementProduct(HttpServletResponse response,
			PanoPerspectiveElementModel model) {
		try {
			List<Map<String, Object>> list = _service
					.queryElementProduct(model);

			JSONArray array = new JSONArray();

			for (Map<String, Object> child : list) {
				JSONObject json = new JSONObject();

				json.put("sn", child.get("sn").toString());
				json.put("id", child.get("id").toString());
				json.put("name", child.get("name").toString());

				if (child.get("elementProductSn") != null) {
					Long mapid = Long.parseLong(child.get("mapid").toString());
					Map<String, String> map = client.getFile(mapid);
					json.put("elementProductSn", child.get("elementProductSn")
							.toString());
					json.put("mapid", EncryptUtil.encode(mapid));
					json.put("url",
							map.get(FileAttributeEnum.VISIT_ADDR.name()));
					json.put("width", map.get(FileAttributeEnum.WIDTH.name()));
					json.put("height", map.get(FileAttributeEnum.HEIGHT.name()));
					json.put("position", child.get("position").toString());
					json.put("scale", child.get("scale").toString());
				}
				array.add(json);
			}

			ajaxOutput(response, array.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("queryElementProductMap")
	public void QueryElementProductInfo(HttpServletResponse response,
			PanoPerspectiveElementProductModel model) {
		try {
			PanoPerspectiveElementProduct product = _service
					.QueryElementProductInfo(model.getSn());

			Map<String, String> map = client.getFile(product.getProductMap());
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sn", product.getSn());
			jsonObject.put("url", map.get(FileAttributeEnum.VISIT_ADDR.name()));
			jsonObject.put("width", map.get(FileAttributeEnum.WIDTH.name()));
			jsonObject.put("height", map.get(FileAttributeEnum.HEIGHT.name()));

			ajaxOutput(response, jsonObject.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("queryPackageTypeName")
	public void QueryPackageTypeName(HttpServletResponse response,
			PanoPerspectiveViewModel model) {
		try {
			List<Map<String, Object>> list = _service.QueryPackageTypeName(model);
			List<String> used_list = _service.QueryUsedPackageTypeName(model.getSn());
			
			JSONObject result = new JSONObject();
			
			JSONObject json = new JSONObject();
			for (Map<String, Object> map : list) {
				JSONObject child = new JSONObject();
				String id = map.get("id").toString();
				String name = map.get("name").toString();
				child.put("id", id);
				child.put("name", name);
				json.put(id, child);
			}
			
			result.put("used",used_list);
			result.put("all", json);
			
			ajaxOutput(response, result.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("viewUpdate")
	public void UpdateViewInfo(HttpServletResponse response,
			PanoPerspectiveViewModel model) {
		try {
			Long mapid = EncryptUtil.decode(model.getMapid());
			model.setBaseMap(mapid);

			Map<String, String> map = client.getFile(mapid);

			String value = _service.UpdateView(model);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", value);
			jsonObject.put("name", model.getViewName());
			jsonObject.put("mapid", mapid);
			jsonObject.put("url", map.get(FileAttributeEnum.VISIT_ADDR.name()));
			jsonObject.put("width", map.get(FileAttributeEnum.WIDTH.name()));
			jsonObject.put("height", map.get(FileAttributeEnum.HEIGHT.name()));
			ajaxOutput(response, jsonObject.toString());
		} catch (IOException e) {

		} catch (SQLException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("layerUpdate")
	public void UpdateLayerInfo(HttpServletResponse response,
			PanoPerspectiveLayerModel model) {
		try {
			String value = _service.UpdateLayer(model);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", value);
			jsonObject.put("name", model.getLayerName());
			jsonObject.put("viewSn", model.getViewSn());
			ajaxOutput(response, jsonObject.toString());
		} catch (IOException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	@RequestMapping("elementUpdate")
	public void UpdateElementInfo(HttpServletResponse response,
			PanoPerspectiveElementModel model) {
		try {
			String value = _service.UpdateElement(model);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("elementId", value);
			jsonObject.put("packageTypeSn", model.getPackageTypeSn());
			jsonObject.put("layerSn", model.getLayerSn());
			jsonObject.put("name", model.getElementName());
			jsonObject.put("elementOrder", model.getElementOrder());
			ajaxOutput(response, jsonObject.toString());
		} catch (IOException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	@RequestMapping("elementExhibitionMapUpdate")
	public void UpdateElementExhibitionMapInfo(HttpServletResponse response,
			PanoPerspectiveElementModel model) {
		try {
			int value = _service.UpdateElementProductSn(model);
			JSONObject jsonObject = new JSONObject();
			Long elementProductSn = model.getElementProductSn();
			if (elementProductSn != null) {
				PanoPerspectiveElementProduct product = _service
						.QueryElementProductInfo(elementProductSn);
				Map<String, String> map = client.getFile(product
						.getProductMap());
				jsonObject.put("sn", product.getSn());
				jsonObject.put("url",
						map.get(FileAttributeEnum.VISIT_ADDR.name()));
				jsonObject
						.put("width", map.get(FileAttributeEnum.WIDTH.name()));
				jsonObject.put("height",
						map.get(FileAttributeEnum.HEIGHT.name()));
				jsonObject.put("position", product.getPosition());
				jsonObject.put("scale", product.getScale());
			} else {
				jsonObject.put("sn", "");
				jsonObject.put("url", "");
				jsonObject.put("width", "");
				jsonObject.put("height", "");
				jsonObject.put("position", "");
				jsonObject.put("scale", "");
			}

			ajaxOutput(response, jsonObject.toString());
		} catch (IOException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("elementProductUpdate")
	public void UpdateElementProductInfo(HttpServletResponse response,
			PanoPerspectiveElementProductModel model) {
		try {
			Long mapid = EncryptUtil.decode(model.getMapid());
			model.setProductMap(mapid);

			String value = _service.UpdateElementProduct(model);

			Map<String, String> map = client.getFile(mapid);
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("sn", model.getProductSn().toString());
			jsonObject.put("elementProductSn", model.getSn());
			jsonObject.put("mapid", model.getMapid());
			jsonObject.put("url", map.get(FileAttributeEnum.VISIT_ADDR.name()));
			jsonObject.put("width", map.get(FileAttributeEnum.WIDTH.name()));
			jsonObject.put("height", map.get(FileAttributeEnum.HEIGHT.name()));
			jsonObject.put("position", model.getPosition());
			jsonObject.put("scale", model.getScale());

			ajaxOutput(response, jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("deleteElement")
	public void DeleteElement(HttpServletResponse response,
			PanoPerspectiveElementModel model) {
		try {
			JSONObject jsonObject = new JSONObject();
			int value = _service.DeleteElement(model);
			ajaxOutput(response, jsonObject.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("deleteLayer")
	public void DeleteLayer(HttpServletResponse response,
			PanoPerspectiveLayerModel model) {
		try {
			JSONObject jsonObject = new JSONObject();
			int value = _service.DeleteLayer(model);
			ajaxOutput(response, jsonObject.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("deleteView")
	public void DeleteView(HttpServletResponse response,
			PanoPerspectiveViewModel model) {
		try {
			JSONObject jsonObject = new JSONObject();
			int value = _service.DeleteView(model);
			ajaxOutput(response, jsonObject.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("updateElementOrder")
	public void UpdateElementOrder(HttpServletResponse response, String pre,
			String next, String layerSn) {
		try {
			JSONObject json = new JSONObject();
			_service.ExchangeElementOrder(pre, next);

			json.put("pre", pre);
			json.put("next", next);
			json.put("layerSn", layerSn);
			ajaxOutput(response, json.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("updateLayerOrder")
	public void UpdateLayerOrder(HttpServletResponse response, String pre,
			String next) {
		try {
			JSONObject json = new JSONObject();
			_service.ExchangeLayerOrder(pre, next);

			json.put("pre", pre);
			json.put("next", next);
			ajaxOutput(response, json.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("QueryPerspectiveByProductSn")
	public Map<String, Object> QueryPerspectiveByProductSn(String houseStyleSn,
			String packageTypeSn, String productSn) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("houseStyleSn", houseStyleSn);
			map.put("packageTypeSn", packageTypeSn);
			map.put("productSn", productSn);
			List<Map<String, Object>> list = _service.QueryPerspectiveInfo(map);

			for (Map<String, Object> child : list) {
				child.put("productSn", productSn);
			}
			result.put("count", list.size());
			result.put("list", JsonUtils.arrayToJson(list.toArray()));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	@RequestMapping("QueryViewElementInfo")
	public void QueryViewElementInfo(HttpServletResponse response,
			String viewSn, String elementSn, String productSn)
			throws SQLException {
		try {
			Long element_sn = Long.parseLong(elementSn);
			Long product_sn = Long.parseLong(productSn);

			PanoPerspectiveViewModel viewModel = new PanoPerspectiveViewModel();
			viewModel.setSn(Long.parseLong(viewSn));

			List<PanoPerspectiveElementProduct> product_list = _service
					.QueryElementProdctList(element_sn);

			Map<String, Object> data = new HashMap<String, Object>();

			List<LinkedHashMap<String, Object>> list = _service
					.QueryViewAllProductInfo(viewModel);
			for (LinkedHashMap<String, Object> map : list) {
				if (map.get("viewMap") != null) {
					Long viewMapKey = Long.parseLong(map.get("viewMap")
							.toString());

					Map<String, String> viewMapFile = client
							.getFile(viewMapKey);
					map.put("viewMapUrl", viewMapFile
							.get(FileAttributeEnum.VISIT_ADDR.name()));
					map.put("viewMapWidth",
							viewMapFile.get(FileAttributeEnum.WIDTH.name()));
					map.put("viewMapHeight",
							viewMapFile.get(FileAttributeEnum.HEIGHT.name()));
					map.put("viewMapId", EncryptUtil.encode(viewMapKey));
				}

				if (map.get("elementId") != null) {
					Long elementId = Long.parseLong(map.get("elementId")
							.toString());
					if (elementId.longValue() == element_sn.longValue()) {
						for (PanoPerspectiveElementProduct product : product_list) {
							if (product.getProductSn().longValue() == product_sn
									.longValue()) {
								Long elementMapKey = product.getProductMap();
								Map<String, String> elementMapFile = client
										.getFile(elementMapKey);
								map.put("elementMapUrl", elementMapFile
										.get(FileAttributeEnum.VISIT_ADDR
												.name()));
								map.put("elementMapWidth", elementMapFile
										.get(FileAttributeEnum.WIDTH.name()));
								map.put("elementMapHeight", elementMapFile
										.get(FileAttributeEnum.HEIGHT.name()));
								map.put("elementMapId",
										EncryptUtil.encode(elementMapKey));

								map.put("position", product.getPosition());
								map.put("scale", product.getScale());
								System.out.println(product.getScale());
								break;
							}
						}
					} else {
						if (map.get("elementMap") != null) {
							Long elementMapKey = Long.parseLong(map.get(
									"elementMap").toString());

							Map<String, String> elementMapFile = client
									.getFile(elementMapKey);

							map.put("elementMapUrl", elementMapFile
									.get(FileAttributeEnum.VISIT_ADDR.name()));
							map.put("elementMapWidth", elementMapFile
									.get(FileAttributeEnum.WIDTH.name()));
							map.put("elementMapHeight", elementMapFile
									.get(FileAttributeEnum.HEIGHT.name()));
							map.put("elementMapId",
									EncryptUtil.encode(elementMapKey));
						}
					}
				}
			}

			List<Map<String, Object>> product_info = new LinkedList<Map<String, Object>>();
			for (PanoPerspectiveElementProduct product : product_list) {
				Map<String, Object> info = new HashMap<String, Object>();
				Long mapKey = product.getProductMap();
				Map<String, String> mapFile = client.getFile(mapKey);
				info.put("productSn", product.getProductSn());
				info.put("url",
						mapFile.get(FileAttributeEnum.VISIT_ADDR.name()));
				info.put("width", mapFile.get(FileAttributeEnum.WIDTH.name()));
				info.put("height", mapFile.get(FileAttributeEnum.HEIGHT.name()));
				info.put("position", product.getPosition());
				info.put("scale", product.getScale());

				if (product.getProductSn().longValue() == product_sn
						.longValue()) {
					product_info.add(0, info);
				} else {
					product_info.add(info);
				}
			}

			data.put("renderList", list);
			data.put("productList", product_info);

			ajaxOutput(response, JsonUtils.mapToJson(data));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("QueryPerspective")
	public String QueryPro(HttpServletResponse response, ModelMap model_map,
			HttpServletRequest request) {

		// 查询参数
/*		String houseStyleSn = "1";
		String packageTypeSn = "1";
		String productSn = "100000";*/
		String houseStyleSn =request.getParameter("house_style_sn");
		String packageTypeSn =request.getParameter("packageTypeSn");
		String productSn =request.getParameter("product_sn");
		// 验证有没有透视图
		Map<String, Object> map = QueryPerspectiveByProductSn(houseStyleSn,
				packageTypeSn, productSn);

		int num = Integer.parseInt(map.get("count").toString());

		if (num != 0) {
			model_map.put("viewlist", map.get("list"));

			List<ProductRelevance> proList = productRelevanceService
					.selProbySN(Long.parseLong(productSn));
			request.setAttribute("proList", proList.get(0));

			List<ProductRelevance> ImgList = productRelevanceService
					.selImgbySN(Long.parseLong(productSn));
			List<Long> images = new ArrayList<Long>();
			for (ProductRelevance productRelevance : ImgList) {
				images.add(productRelevance.getLEFT_IMG_SN());
				images.add(productRelevance.getDOWN_IMG_SN());
				images.add(productRelevance.getFULL_IMG_SN());
				images.add(productRelevance.getBANNER_IMG_SN());
				images.add(productRelevance.getMATERIAL_IMG_SN());
				images.add(productRelevance.getFABRIC_IMG_SN());
			}
			request.setAttribute("images", images);
			return "/perspective/pro";

		}

		return this.redirect("/usersSide/carshow2");

	}
}
