import KotlinTasks.Seminar_2.Command;
import KotlinTasks.Seminar_2.Person
import KotlinTasks.Seminar_2.Seminar_2
import KotlinTasks.Seminar_3.Seminar_3
import KotlinTasks.Seminar_4.Seminar_4


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val seminar4 = Seminar_4();
    seminar4.run();

    return;

    /*fun Person.getInfo(aAll:Boolean):String{
       return this.name+" "+this.phone+" "+this.email;
    }

    val p:Person=Person("asda","asdasd","asdasd");

    println(p.getInfo(true));

    val sum = {a:Int, b:Int ->
        println("Call SUM");
        a+b;

    }

    sum(3,6);
    sum.invoke(4,7);

    val munus :(Int, Int)->Int = {a,b ->
        println("Call MINUS");
        a-b};

    munus(45,7);

    val dec:(Int) -> (Int) = { -it };

    val getName: Person.(aValue:Boolean) ->String = {
        this.name;
    }

    println(p.getName(true));

    fun checkArray(arr: IntArray, predicate: (Int, Int) -> Int):Boolean{
        for (e in arr){
            if (predicate(e,e) != -1)
                return false;

        }
        return true;
    }

    fun checkElement(a:Int, b:Int):Int {
        return a+b;
    }

    val a = intArrayOf(1,2,3);

    checkArray(a,::checkElement);

   /* inline fun Person.IsValidData(action: (Int, String)->Unit){
       action(0, this.toString());
    }*/

    fun <T> toStrConcat(a:T, b:T):String{
        return a.toString()+b.toString();
    }

    fun <T:Number> sumTo(a:T, b:T):Double{
        return a.toDouble()+b.toDouble();
    }

    with (p){
        testVar = "Ivan";
    }

    p.run {
        testVar = "Sergey";
    }

   val p1 = Person("", "", "").apply { this.testVar = "VAR"; }

   println(p1.testVar);

   val p2:Person = Person("", "", "").also { println(it.toString()); }

   fun extractUserEmail(value:String?):String{
       return value?.let{ value.substringBefore("@") }.orEmpty();
   }*/
}