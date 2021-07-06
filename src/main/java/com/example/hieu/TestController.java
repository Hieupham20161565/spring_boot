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
    FileWriter fw = new FileWriter(file);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("ahghfgfg");
    bw.newLine();
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    String line;
    while((line = br.readLine()) != null){
        System.out.print(line);
    }


} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}

        return a;



    }

}