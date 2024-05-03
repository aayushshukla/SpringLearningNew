// constructor : It is a special type of method.used to intialiase an object .
// constructor have a same name as class name
// there is no return type for a constructor
// constructors are invoked automatically when object is created
// when a  functionality of a function depends on an object it is knows methods.Java have methods .
// constructor may have arguments

// access modifiers - public,protected,private,default
// by default every class , method ,variable ,etc are default
// class - default, public
// if a class is public than file should be saved with same name as classname 
public class Animal
{
   String food;      
   Animal(String foodname)
         {
             food = foodname;
         
         }
     void food()
       {

           System.out.println("Eats "+food);

       }

   public static void main(String...s)
      {
         Animal tiger = new Animal("Meat");
         Animal cow = new Animal("Grass");
         tiger.food();
         cow.food();
                 

      }

}