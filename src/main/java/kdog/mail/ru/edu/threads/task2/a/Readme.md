Добавить проверку условия прерывания.
В Java нет механизма для "прямого" прерывания потока ( если не считать Deprecated методы stop, suspend)
"Прерывание" организовано обычно следующим паттерном:
действия в потоке выполняются в цикле, где условием проверки является флаг прерывания.
В ThreadApi уже реализованы необходимые методы.

Подсказка:
Дословная логика работы должна быть следующей:
Выполнять работу пока флаг прерывания не установлен в true.





Задача:

1. Разобраться почему класс CatLife работает бесконечно
2. Исправить ситуацию


Подсказка:
В следующем примере поток успешно поспит 2 раза, 
но третий сон будет прерван. Метод sleep2sec узнает об этом, но утаит эту информацию. Поэтому, поток будет выполнятся бесконечно, несмотря на проверку isInterrupted().

Тут есть 2 решения:
1. Пробросить исключение.
2. Снова установить флаг прерывания: Thread.currentThread().interrupt() в catch-секции, чтобы условие цикла выполнилось.