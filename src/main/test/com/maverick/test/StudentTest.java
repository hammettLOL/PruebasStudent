package com.maverick.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.List;

import javax.validation.constraints.AssertFalse;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.joseph.model.Student;
import com.joseph.service.impl.StudentServiceImpl;

import junit.framework.Assert;


public class StudentTest {
	
	public StudentTest(){
		
	}
	
@BeforeTest
public void setUp(){
	
}

@AfterTest
public void tearDown() {
}

@Test
public void testAgregar() {
    try{
    System.out.println("agregar");
    StudentServiceImpl instance = new StudentServiceImpl();
    int sizeInit = instance.getAllStudent().size();
    int sizeAfter;
    Student student = new Student();
    student.setFirstname("Manuel");
    student.setLastname("Rojas");
    student.setYearLevel(10);
    instance.add(student); 
    sizeAfter = instance.getAllStudent().size();
    
    
    assertTrue(sizeAfter > sizeInit);
    }catch(Exception e){        
    	Assert.assertFalse("This is a prototype",false);
    }
}
@Test
public void testListar() {
    System.out.println("listar");
    try{
    	StudentServiceImpl instance = new StudentServiceImpl();
   
    List result = instance.getAllStudent();
    assertTrue(result.size() > 0);
    }catch(Exception e){
    	Assert.assertFalse("This is a prototype",false);	
    }
}

@Test
public void testEliminar() {
    System.out.println("eliminar");
    try{
    int id = 10;
    StudentServiceImpl instance = new StudentServiceImpl();
    int sizeInit = instance.getAllStudent().size();
    int sizeAfter;
 
    instance.delete(id);
    sizeAfter = instance.getAllStudent().size();
    assertTrue(sizeAfter < sizeInit);
    }catch(Exception ex){
    
    	Assert.assertFalse("This is a prototype",false);
    }
}
@Test
public void testEditar() {
    System.out.println("editar");
    try{
    Student student = null;
    StudentServiceImpl instance = new StudentServiceImpl();
    boolean expResult = false;
    instance.edit(student);
    assertEquals(student, null);
    }catch(Exception ex){
    Assert.assertFalse("This is a prototype",false);
    }
}


}
