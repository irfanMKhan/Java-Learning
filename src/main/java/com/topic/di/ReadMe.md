
```
First, an abstract class isn't component-scanned since it can't be instantiated 
without a concrete subclass.
```

```
Second, setter injection is possible in an abstract class, but it's risky if we don't 
use the final keyword for the setter method. The application may not be stable if a 
subclass overrides the setter method.
```

```
Third, as Spring doesn't support constructor injection in an abstract class, we should 
generally let the concrete subclasses provide the constructor arguments. This means 
that we need to rely on constructor injection in concrete subclasses.
```

```
And finally, using constructor injection for required dependencies and setter injection 
for optional dependencies is a good rule of thumb. However, as we can see with some of 
the nuances with abstract classes, constructor injection is generally more favourable 
here.
```

