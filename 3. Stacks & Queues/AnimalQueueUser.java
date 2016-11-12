/*
*Animal Shelter: Data Structure to hold a dogs and cats. It supports three dequeue options.
* 1. DequeueAny: Dequeue last animal irrespective of its type.
* 2. DequeueDog: Dequeue last dog
* 3. DequeueCat: Dequeue last cat
*/

import java.util.*;

class Animal{
    String name;
    int timeStamp;
    
    public Animal(String s){
        name = s;
    }
    
    boolean olderThan(Animal a){
        if(this.timeStamp>a.timeStamp){
            return false;
        }
        return true;
    }
    void setTime(int time){
        this.timeStamp = time;
    }
}

class Dog extends Animal{
    public Dog(String s){
        super(s);
    }
}

class Cat extends Animal{
    public Cat(String s){
        super(s);
    }
}

class AnimalQueue{
    LinkedList<Dog> dogList = new LinkedList<>();
    LinkedList<Cat> catList = new LinkedList<>();
    int timeStamp = 0;
    
    public void enqueue(Animal a){
        a.setTime(timeStamp++);
        if(a instanceof Dog){
            dogList.add((Dog)a);
        }else if(a instanceof Cat){
            catList.add((Cat)a);
        }
    }
    
    public Dog dequeueDog(){
        Dog temp = dogList.getFirst();
        dogList.remove(dogList.getFirst());
        return temp;
        
    }
    
    public Cat dequeueCat(){
        Cat temp = catList.getFirst();
        catList.remove(catList.getFirst());
        return temp;
    }
    
    public Animal dequeueAny(){
        Cat tempCat = catList.peek();
        Dog tempDog = dogList.peek();
        
        if(tempCat.olderThan(tempDog)){
            catList.remove(tempCat);
            return tempCat;
        }else{
            dogList.remove(tempDog);
            return tempDog;
        }
    }
}

public class AnimalQueueUser{
    public static void main(String[] args){
        AnimalQueue q = new AnimalQueue();
        Dog dog1 = new Dog("Dog1");
        q.enqueue(dog1);
        Dog dog2 = new Dog("Dog2");
        q.enqueue(dog2);
        Cat cat1 = new Cat("Cat1");
        q.enqueue(cat1);
        Cat cat2 = new Cat("Cat2");
        q.enqueue(cat2);
        Dog dog3 = new Dog("Dog3");
        q.enqueue(dog3);
        
        System.out.println(q.dequeueCat().name);
        System.out.println(q.dequeueDog().name);
        System.out.println(q.dequeueAny().name);
        
    }
}