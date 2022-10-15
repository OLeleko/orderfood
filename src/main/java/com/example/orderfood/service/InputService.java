package com.example.orderfood.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class InputService {

    private InputStream inputStream;
    private BufferedReader bufferedReader;

    public InputService() {
    }

    public InputService(InputStream inputStream) {
        this.inputStream = inputStream;
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public int getChoice() {
        int counter = 3;
        int result = 0;
        while (counter > 0){
            try {
                result = Integer.parseInt(bufferedReader.readLine());
                if(result > 0){
                    break;
                }else{
                    System.out.println("Wrong choice. Try again.");
                    counter --;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong choice. Try again.");
                counter --;
            }catch (IOException e) {
                System.out.println("Wrong choice. Try again.");
                counter --;
            }
        }
        if(counter == 0){
            System.out.println("You did wrong choice 3 times. Good bye.");
            System.exit(0);
        }

        return result;
    }

    public void closeBuffer(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
