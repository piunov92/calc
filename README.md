<h1 style="color:rgb(140, 158, 251); text-align:center">ТЕСТОВАЯ ЗАДАЧА "КАЛЬКУЛЯТОР"</h1>

<div>
    <div style="background-color: #f5f5f5;">   
        <h2 style="padding:20px">Описание</h2>
        <p style="padding: 20px; line-height: 24px">Создай консольное приложение "Калькулятор". 
            Приложение должно читать из консоли введенные пользователем строки, числа, арифметические операции проводимые между ними и выводить в консоль результат их выполнения.
            Реализуй класс Main с методом public static String calc(String input). Метод должен принимать строку с арифметическим выражением между двумя числами и возвращать строку с результатом их выполнения. 
            Ты можешь добавлять свои импорты, классы и методы. Добавленные классы не должны иметь модификаторы доступа (public или другие).</p>
    </div>
    <div>
        <h2>Требования:</h2>
        <ol>
            <li style="line-height: 24px">Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.<strong> Данные передаются в одну строку (смотри пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными</strong>.</li>
            <li style="line-height">Калькулятор умеет работать как с арабскими (1,2,3,4,5...), так и с римскими (I,II,III,IV,V...) числами.</li>
            <li style="line-height">Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.</li>
            <li style="line-height">Калькулятор умеет работать только с целыми числами.</li>
            <li style="line-height">Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.</li>
            <li style="line-height">При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.</li>
            <li style="line-height">При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.</li>
            <li style="line-height">При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.</li>
            <li style="line-height">Результатом операции деления является целое число, остаток отбрасывается.</li>
            <li style="line-height">Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль. Результатом работы калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы, выбрасывается исключение</li>
        </ol>
    </div>
</div>