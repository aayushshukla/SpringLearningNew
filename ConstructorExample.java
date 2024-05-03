// constructor : It is a special type of method.used to intialiase an object .
// constructor have a same name as class name
// there is no return type for a constructor
// constructors are invoked automatically when object is created
// when a  functionality of a function depends on an object it is knows methods.Java have methods .

class Animal
{
     Animal()
         {
             System.out.println("Constructor is running....");
         }
    // method declaration ,defination ,calling

   //  accessmodifier returntype methodname(arg1,arg2..argn) argument are optional 
     void food()
       {

           System.out.println("food....");

       }

   public static void main(String...s)
      {
         Animal tiger = new Animal();
         Animal cow  = new Animal();
         Animal bear  = new Animal();
         //tiger.food(); // calling of food method
         //cow.food(); 


      }

}