package KotlinTasks.Seminar_2

class CommandAddPhone(var person: Person) :Command() {
    override fun isValid():Boolean{
        val phone = person.phone;

        //проверяем номер телефона на валидность
        //наверняка есть класс работы с регулярными выражениями но я увы пока не знаком с ним
        //распарсим ручками
        //должны быть только цифры, знак + и дефис -

        //если плюс где то в середине номера
        if (phone.indexOf('+')>1) return false;

        val myStringNum = "0 1 2 3 4 56 7 8 9 -";

        for (i in 0..< phone.length){
           if (phone[i] !in myStringNum) return false;

        }

         return true;
    }
}