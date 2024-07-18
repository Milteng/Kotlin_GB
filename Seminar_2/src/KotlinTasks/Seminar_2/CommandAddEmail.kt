package KotlinTasks.Seminar_2

import KotlinTasks.Seminar_2.Command;

class CommandAddEmail(var person: Person):Command() {
    override fun isValid():Boolean{
        val email = person.email;
        var cnt_= 0;
        var cnt_pont = 0;
        //можно и замороченнее сделать проверку на маску ввода
        //но пока по совим навыкам позволю себе сделать немного попроще
        for (i in 0..< email.length){
            val c = email[i];
            if (c == '@') cnt_++;
            if (c == '.') cnt_pont++;

        }
        if (cnt_!=1) return false;
        if (cnt_pont<1) return false;
        return true;
    }
}