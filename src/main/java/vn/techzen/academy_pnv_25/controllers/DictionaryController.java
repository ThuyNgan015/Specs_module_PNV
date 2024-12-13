package vn.techzen.academy_pnv_25.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DictionaryController {
    private final Map<String, String> dictionaryMap = Map.ofEntries(
            Map.entry("hello", "xin chào"),
            Map.entry("dog", "chó"),
            Map.entry("cat", "mèo"),
            Map.entry("book", "sách"),
            Map.entry("pen", "bút"),
            Map.entry("car", "ô tô"),
            Map.entry("table", "bàn"),
            Map.entry("chair", "ghế"),
            Map.entry("tree", "cây"),
            Map.entry("flower", "hoa"),
            Map.entry("bird", "chim")
    );

    @GetMapping("/dictionary")
    public ResponseEntity<String> distionary(@RequestParam(defaultValue = "") String word){
        String dictionary = dictionaryMap.get(word);
        if(dictionary == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dictionary);
    }
}
