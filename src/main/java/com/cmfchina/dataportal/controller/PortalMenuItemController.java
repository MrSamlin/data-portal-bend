package com.cmfchina.dataportal.controller;

import com.cmfchina.dataportal.entity.DataMenuItem;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.entity.ResponseResult;
import com.cmfchina.dataportal.entity.Result;
import com.cmfchina.dataportal.service.FileStorageService;
import com.cmfchina.dataportal.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menuItem")
public class PortalMenuItemController {

    @Autowired
    private MenuItemService menuItemService;


    @Autowired
    private FileStorageService fileStorageService;
    // 查询所有数据分类
   @GetMapping("/getTopMenuItem")
    public  List<DataMenuItem> getTopMenuItem() {
       List<DataMenuItem> topMenuItem = menuItemService.getTopMenuItem();
       return topMenuItem;
    }


    @GetMapping("/getAllMenuItem")
    public List<DataMenuItem> getAllMenuItem() {
        return   menuItemService.getAllMenuItem();
    }



    @PostMapping("/getTopMenuItemList")
    public Result<List<DataMenuItem>> getTopMenuItemList(@RequestBody QueryDao dao) {
        List<DataMenuItem> topMenuItemList = menuItemService.getTopMenuItemList(dao);
        return new Result<List<DataMenuItem>>().buildPageResult( topMenuItemList, menuItemService.countTopList(dao),dao.getPage(),dao.getSize());
    }


    @PostMapping("/getChildMenuItemList")
    public  Result<List<DataMenuItem>> getChildMenuItemList(@RequestBody QueryDao dao) {
        return new Result<List<DataMenuItem>>().buildPageResult( menuItemService.getChildMenuItemList(dao), menuItemService.countChildList(dao),dao.getPage(),dao.getSize());
    }


    @PostMapping("/getChildMenuItem")
    public List<DataMenuItem> getChildMenuItem(@RequestBody QueryDao query) {
        List<DataMenuItem> childMenuItem = menuItemService.getChildMenuItem(query);
        return childMenuItem;
    }



    @PostMapping("/insertMenuItem")
    public ResponseEntity<Integer> insertMenuItem(  @RequestBody DataMenuItem dataMenuItem) {
        return   ResponseEntity.ok( menuItemService.insertMenuItem(dataMenuItem));
    }

    @PostMapping("/updateMenuItem")
    public   ResponseEntity<Integer> updateMenuItem(  @RequestBody DataMenuItem dataMenuItem) {
        return ResponseEntity.ok( menuItemService.updateMenuItem(dataMenuItem));
    }


    @DeleteMapping("/{id}")
    public   ResponseEntity<Map<String,Object>> deleteTopMenuItem(@PathVariable Integer id) {
        Map<String, Object> responseData = new HashMap<>();
        StringBuilder resultMsg =new StringBuilder();
        //  删除绑定的图标
        DataMenuItem menuItemVo = menuItemService.getMenuItemById(id);
        StringBuilder stringBuilder = fileStorageService.deleteFile(menuItemVo.getIconUrl()) ? resultMsg.append("图片删除成功") : resultMsg.append("图片删除失败");
        menuItemService.deleteTopMenuItem(id);
        stringBuilder.append("&菜单删除成功");
        responseData.put("message",stringBuilder.toString());
        return  ResponseEntity.ok(responseData);
    }

    /**
     * 上传图片
     * @param file 上传的文件
     * @param prefix 可选的URL前缀
     * @return 上传结果
     */
    @PostMapping("/uploadIcon")
    public ResponseEntity<Map<String,Object>> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "prefix", required = false) String prefix) {
        Map<String, Object> responseData = new HashMap<>();
        try {
            if (file.isEmpty()) {
                responseData.put("success", false);
                responseData.put("message", "上传的文件为空");
                return  ResponseEntity.ok(responseData);
            }
            // 检查文件类型
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return  ResponseEntity.ok(responseData);
            }

            // 调用服务保存文件
            String fileName = file.getOriginalFilename();
            String fileUrl = fileStorageService.storeFile(file, prefix);
            responseData.put("code",200);
            responseData.put("url", fileUrl);
            responseData.put("name", fileName);
            responseData.put("size", file.getSize());
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.put("success", false);
            responseData.put("message", "上传失败: " + e.getMessage());
            return  ResponseEntity.ok(responseData);
        }
    }

    /**
     * 删除图片
     * @param url 图片URL
     * @return 删除结果
     */
    @DeleteMapping("/deleteIcon")
    public ResponseEntity<ResponseResult> deleteImage(@RequestParam("url") String url) {
        try {
            boolean deleted = fileStorageService.deleteFile(url);
            if (deleted) {
                return ResponseEntity.ok(new ResponseResult(200, "删除成功", null));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseResult(404, "文件不存在或已被删除", null));
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseResult(500, "删除失败: " + e.getMessage(), null));
        }
    }
}