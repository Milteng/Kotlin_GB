package KotlinTasks.Seminar_2;

data class Person(val name:String, val phone: String, val email: String){
    var testVar:String = "";

    var listEmails:MutableList<String> = mutableListOf();
    var listPhone:MutableList<String> = mutableListOf();

    init {
        if (this.phone!="") listPhone.add(this.phone);

        if (this.email!="") listEmails.add(this.email);

    }



    fun findEmail(value : String):Int{
        return listEmails.indexOf(value);
    }

    fun findPhone(value : String):Int{
        return listPhone.indexOf(value) ;
    }

    fun addPhone(value : String):Int{
        val i = findPhone(value);

        if (i != -1) {
            listPhone.set(i,value);
            return i;
        }
        else {
             listPhone.add(value);
             return  listPhone.size - 1;
        }
    }

    fun addEmail(value : String):Int{
        val i = findEmail(value);

        if (i != -1) {
            listEmails.set(i,value);
            return i;
        }
        else {
            listEmails.add(value);
            return  listEmails.size - 1;
        }
    }

    override fun toString(): String {
        return "Name: $name\nPhones: $listPhone\nEmails: $listEmails"


    }

    fun getListString(l:MutableList<String> ):String{
        var s:String="";
        for (a in l) {
            if (s!="") {
                s = s + ","+"\"" + a + "\""
            }
            else
                s = "\"" + a + "\"";

        }
        return s;
    }
}