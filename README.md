# Observer

4. [Task4 : Слайдер картинок(Итератор)](#Task4)
5. [Task5 : Индикатор загрузки(Строитель)](#Task5)

<a name="Task4"></a>
## Task4 <i>Индикатор загрузки(Строитель)</i>

<h2>  </h2>

* В программе можно листать картинки в перёд и назад книпками next и back соответственно
* В программе можно запустить слайд шоу предварительно задав скорость переключения слайдов (start, play)
* Кнопкой directory можно открыть проводник файлов, выбрать любую картинку на вашем компьютере и она будет отображена

![image](https://user-images.githubusercontent.com/96237923/202486688-19d5e5ab-c4eb-4bee-b6ed-bfa6932b6b4a.png)

<a name="Task5"></a>
## Task5 <i>Индикатор загрузки(Строитель)</i>

<h4> 
Паттерн Строитель (Builder)  используется для создания новых объектов по одному и тому же процессу конструирования. 
Это даёт возможность использовать один и тот же алгоритм процесса строительства для получения разных видов объектов.
</h4>

* Интерфейс Builder объявляет шаги конструирования продуктов, общие для всех видов строителей.
* ConcreteBuilder реализуют шаги конструирования, каждый по-своему. Конкретные строители могут производить объекты разного представления.

* Product  — создаваемый объект.  
* Director определяет порядок вызова строительных шагов для построения той или иной конфигурации продуктов.
* Client - контекст использования паттерна.

Использования Строителя:
дает больший контроль над процессом создания объектов;
позволяет варьировать внутреннее представление объекта;
отделяет процесс конструирования объекта от его внутреннего представления



![image](https://user-images.githubusercontent.com/96237923/209245919-87353973-6616-41af-b7b5-59f1587098cd.png)
![image](https://user-images.githubusercontent.com/96237923/209245955-c69da7b6-2b89-48ad-adf5-17aba9408660.png)
