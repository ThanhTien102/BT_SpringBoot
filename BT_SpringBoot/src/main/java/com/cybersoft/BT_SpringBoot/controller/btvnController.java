package com.cybersoft.BT_SpringBoot.controller;

import com.cybersoft.BT_SpringBoot.dto.CommentDTO;
import com.cybersoft.BT_SpringBoot.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Comment;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class btvnController {
    // Bai 1
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?>  layHoaDon(@PathVariable String orderId,
                                        @RequestParam String currency){
        return  ResponseEntity.ok("orderId: "+orderId +"\ncurrency: "+currency);
    }
    // Bai 2
    @PostMapping("/comments")
    public ResponseEntity<?> dangBinhLuan(@RequestParam String postId, @RequestBody CommentDTO request)
    {
        return   ResponseEntity.ok("content :"+request.getComment());
    }
    // Bai 3
    @GetMapping("/users/{id}")
    public ResponseEntity<?>  layThongTinNguoiDung(@PathVariable String id,@RequestHeader("X-Cliendt-Version") String version)
    {
        return   ResponseEntity.ok("X-Cliendt-Version: "+version);
    }
    // Bai 4
    @GetMapping("/search")
    public ResponseEntity<?> ketQuaTimKiem(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam String keyword )
    {
      return ResponseEntity.ok("Keyword:" + keyword +  "\nPage: " + page + "\nSize: " + size);
    }
    // Bai 5
    @GetMapping("/tag")
    public ResponseEntity<List<String>> layDanhSach(@RequestParam List<String> tags)
    {
      return ResponseEntity.ok(tags);
    }
    // Bai 6
    @GetMapping("/filter")
    public ResponseEntity<Map<String,String>> layThongTinGiay(@RequestParam Map<String,String> Giay)
    {
        return ResponseEntity.ok(Giay);
    }
    // Bai 7
    @PostMapping("/login-form")
    public ResponseEntity<?> dangNhap(@RequestParam String username, @RequestParam String password)
    {
        return ResponseEntity.ok("Username: " + username + " | Password: " + password);
    }
    // Bai 8
    @PostMapping("/documents")
    public ResponseEntity<?> nhanTaiLieu(MultipartFile file,
                                        @RequestParam String title,
                                        @RequestParam String description,
                                        @RequestParam List<String> tags)

    {
        return  ResponseEntity.ok("FileName: " + file.getOriginalFilename() + " (" + file.getSize() + " bytes)\n"
                + "Title: " + title + "\n"
                + "Description: " + description + "\n"
                + "Tags: " + tags);
    }
    // Bai 9
    @PutMapping("/users/{id}")
    public ResponseEntity<?> capNhat(@RequestBody UserDTO request, @PathVariable String id)
    {
        return ResponseEntity.ok(request);
    }
    // Bai 10
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> xoaBaiViet(@PathVariable String id,@RequestHeader String Authorization)
    {
        return ResponseEntity.ok("Đã xóa bài viết có ID: " + id + " | Authorization: " + Authorization);
    }
}
















































