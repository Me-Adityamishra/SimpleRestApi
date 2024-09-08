package com.AdityaRestApi.Controller;
import com.AdityaRestApi.Entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/student")
public class MyController {
  private Map<Long, Student> student=new HashMap<>();

  @GetMapping
  public List<Student> getAll()
  {
      return new ArrayList<>(student.values());
  }

    @PostMapping
    public boolean createStudent(@RequestBody Student myStudent)
    {
        student.put(myStudent.getId(),myStudent);
        return true;
    }
  @GetMapping("/id/{myId}")
    public Student getStudentById(@PathVariable Long myId)
    {
      return student.get(myId);
    }
    @DeleteMapping("/id/{myId}")
    public Student deleteStudentById(@PathVariable Long myId)
    {
        return student.remove(myId);
    }
    @PutMapping("id/{id}")
    public  Student updateStudentById(@PathVariable Long id,@RequestBody Student myStudent)
    {
       return  student.put(id,myStudent);
    }

}
