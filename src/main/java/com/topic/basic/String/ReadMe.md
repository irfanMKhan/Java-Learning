
The grow method in the ArrayList class gives the new size array. In Java 8 and later 
The new capacity is calculated which is 50% more than the old capacity and the array 
is increased by that capacity. It uses Arrays.copyOf which gives the array increased 
to the new length by right shift operator also it will grow by 50% of old capacity.

```
int newCapacity = oldCapacity + (oldCapacity >> 1);
```

For example, if the Array size is 10 and already all the rooms were filled by the 
elements, while we are adding a new element now the array capacity will be increased
as 10+ (10>>1) => 10+ 5 => 15. Here the size is increased from 10 to 15. To increase
the size by 50% we use the right shift operator. While in Java 6 it’s totally 
different from the above calculation on increasing the size of the Array, 
in java 6 the capacity increases by the amount to 1.5X

```
int newCapacity = (oldCapacity * 3)/2 + 1;
```

Which among String or String Buffer should be preferred when there are a lot of updates required to be done in the data?
```
Because StringBuilder is quicker than StringBuffer, it is advised to utilize it wherever possible. 
However, StringBuffer objects are the best choice if thread safety is required.
```