package vn.techzen.academy_pnv_25;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DictionaryController {
    private final Map<String, String> dictionaryMap = Map.ofEntries(
            Map.entry("hello", "xin chào"),
            Map.entry("apple", "quả táo"),
            Map.entry("banana", "quả chuối"),
            Map.entry("orange", "quá can"),
            Map.entry("Leson", "quà chanh"),
            Map.entry("nelon", "quả dưa"),
            Map.entry("satermelon","quả cưa hấu"),
            Map.entry("blueberry", "quả việt quất")
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
