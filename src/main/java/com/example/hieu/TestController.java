package com.example.hieu;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController()
@RequestMapping("index")
public class TestController {


    @PostMapping("/writefile")
    public Test index(@RequestBody Test text) {
        try {
            File file = new File("data.dontfile.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.append("id,name \n");
            bw.write(text.getId()+","+text.getName());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @GetMapping("/readfile")
    public String readfile() {
        String s ="";
        try {
            File file = new File("data.dontfile.txt");
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
                System.out.println(line);
                s += line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @DeleteMapping("/deleteFile")
    public void deleteFile(String id) {
        try {
            File file = new File("data.dontfile.txt");
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append("");
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


