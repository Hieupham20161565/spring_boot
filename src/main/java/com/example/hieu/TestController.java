package com.example.hieu;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController()
@RequestMapping("index")
public class TestController {
    @GetMapping("/")
    public String index(String a)  {
//        File file = new File("")
        try {
            File file =   ResourceUtils.getFile("/src/main/resources/data.dontfile.txt");
            try (FileWriter fw = new FileWriter(file);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("cccadsa");
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a;
    }

    @RequestMapping(value = "index2",method = RequestMethod.GET)
    public String index2(){
        return "hello 2";
    }

    @PostMapping("testPort")
    public String testPost(String a){
        return a;
    }

    @PostMapping("portClassTest")
    public Test portClass(@RequestBody Test test){
        return test;
                                                                                                                                                          }
}
