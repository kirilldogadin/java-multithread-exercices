ДО этого рассматривался ReentrantLock
Также существует ReadWriteLock

Представьте , что вам не нужно блокировать поток при параллельном чтении.

Примерами такого кейса могут быть:
Система кеша - зачем нам блокировать чтение значений из разных потоков?
Глобальный настройки - зачем нам давать доступ к ним только по очереди?
подумайте сами над подобными кейсами.


Представьте что вы пишите кэш, данные в котором редко обновляются, но часто читаются. 

ПОяснение:
В задании даются 2 примера
Посмотрите реализацию Фулл локер и фулл локер 2
Разница в том, что 
при использовании Асбтракт Локер достаточно иплементировать методы