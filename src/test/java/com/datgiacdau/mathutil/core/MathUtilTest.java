/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.datgiacdau.mathutil.core;

import static com.datgiacdau.mathutil.core.MathUtil.*;
//import static là kĩ thuật dành riêng hàm static
//gọi hàm mà bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author DELL
 */
public class MathUtilTest {
    
    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử
    
    //chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][]{
            {1,1},
            {2,2},
            {5,120},
            {6,720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //hàm cung cấp data, ngầm định thứ tự
    //của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgTeturnsWell(int input, long expected) {
        assertEquals(expected,getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgTeturnsWell(){
//        assertEquals(120,getFactorial(5));
//    }
    
    //bắt ngoại lệ khi đưa data ngoài vùng
    //hàm  nhận tham số t2 là 1 cái object có code implement cái
    //functional interface tên là Excecutable - có 1 hàm duy nhất ko code
    //tên là execute()
    //chơi chậm
    @Test
    public void testGetFactorialGivenWrongArgThrowException(){
//Cách 1
//    Executable exObject = new Executable() {
//        @Override
//        public void execute() throws Throwable {
//            getFactorial(-5);
//        }
//    };

//Cách 2
//        Executable exObject = () -> getFactorial(-5);


        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
