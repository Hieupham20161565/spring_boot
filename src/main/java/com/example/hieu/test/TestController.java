package com.example.hieu.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Arrays;

@RestController()
@RequestMapping("index")
@Slf4j
public class TestController {


    @PostMapping("/writefile")
    public Test index(@RequestBody Test text) {
        try {
            log.warn("steam {}", Arrays.stream(docFile("data.dontfile.txt").split(",")).filter(s -> s.equalsIgnoreCase(text.getId())));
            log.warn("{}", docFile("data.dontfile.txt").compareTo(text.getId()));
//            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//            if (docFile(file).compareTo("id , name ") < 0) {
//                bw.append("id , name \n");
//            }

//            if (docFile(file).compareTo(text.getId()) < 0) {
//                bw.write(text.getId() + " , " + text.getName() + "\n");
//            } else {
//                return new Test();
//            }
//            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @GetMapping("/readfile")
    public String readFile() {
        String s = "";
        try {
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new FileReader("data.dontfile.txt"));
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
        String a = "";
        try {
            File file = new File("data.dontfile.txt");
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new FileReader(file));
            sb.append("");
            sb.append("\n");
            String line;
            while ((line = br.readLine()) != null) {
                a += line;

                System.out.println(line);
            }
            System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String docFile(String file) throws IOException {
        String s = "";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            s += line;
        }
        log.warn(s);
        return s;
    }

}


