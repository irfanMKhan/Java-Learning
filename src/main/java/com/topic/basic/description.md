#### Java is Pass by Value, Not Pass by Reference

+ Pass by value:
```
The method parameter values are copied to another variable 
and then the copied object is passed to the method. The method uses the copy.
```

+ Pass by reference:
``` 
An alias or reference to the actual parameter is passed to the method. 
The method accesses the actual parameter.
```


#### @Override Annotation
Even if you don't use @Override annotation , method in child class will be overrided. 
+ if you misspell method name/parameters in child class, it will create a new method instead of 
  override.@Override annotation will generate error if override is not successful or new method
  is created.
+ Improved code readability. 