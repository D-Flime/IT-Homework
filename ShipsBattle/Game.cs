using System;

namespace ShipsBattle
{
    public class Game
    {
        private string gameState = "gameStart";
        private Player Player1 = new Player();
        private Player Player2 = new Player();
        private Player order;
        
        private void renderMaps(){
            var ofY = 3;
            var ofX = 3;
            var mn2 = 30;
            Console.Clear();
            //Отрисовать цифры координат
            for (var i = 3; i < 13; i++){
                //Мапа игрока
                Console.SetCursorPosition(ofX, i+1);
                Console.WriteLine("{0}",i-2);
                Console.SetCursorPosition(i*2, ofY);
                Console.WriteLine("{0}",i-2);
                //Мапа противника
                Console.SetCursorPosition(ofX+mn2, i+1);
                Console.WriteLine("{0}",i-2);
                Console.SetCursorPosition(i*2+mn2, ofY);
                Console.WriteLine("{0}",i-2);
            }
            //Отрисовать мапы
                //Мапа игрока
            for (var i = 1; i < 11; i++){
                for (var j = 1; j < 11; j++){
                    if (order.selfMap[i, j].ship && order.selfMap[i, j].shot){
                        Console.SetCursorPosition(ofX+1+i*2, ofY+j);
                        Console.WriteLine("{X}");
                    } else if (order.selfMap[i, j].ship){
                        Console.SetCursorPosition(ofX+1+i*2, ofY+j);
                        Console.WriteLine("■");
                    } else if (order.selfMap[i, j].shot){
                        Console.SetCursorPosition(ofX+1+i*2, ofY+j);
                        Console.WriteLine("*");
                    } else {
                        Console.SetCursorPosition(ofX+1+i*2, ofY+j);
                        Console.WriteLine("~");
                    }
                }
            }
                //Мапа противника
            for (var i = 1; i < 11; i++){
                for (var j = 1; j < 11; j++){
                    if (order.enemyMap[i, j].ship && order.enemyMap[i, j].shot){
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("{X}");
                    } else if (order.enemyMap[i, j].ship){
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("■");
                    } else if (order.enemyMap[i, j].shot){
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("*");
                    } else {
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("~");
                    }
                }
            }
        }

        private void arrangeShip()
        {
            var x = 0; var y = 0;
            var length = 4;
            var dir = "";
            while (length > 0)
            {
                for (byte c = 0; c <= 4-length; c++){
                    Console.WriteLine("Введите расположение корабля длины {0}", length);
                    GetXY:
                    while(true)
                    {
                        Console.Write("x: "); x = Convert.ToInt32(Console.ReadLine());
                        if (x > 0 && x < 11){
                            break;
                        }
                        Console.WriteLine("Выход за пределы границы");
                    }
                    while(true)
                    {
                        Console.Write("y: "); y = Convert.ToInt32(Console.ReadLine());
                        if (y > 0 && y < 11){
                            break;
                        }
                        Console.WriteLine("Выход за пределы границы");
                    }
                    if (order.selfMap[x, y].ship){
                        Console.WriteLine("Пересечение с другим кораблём!");
                        goto GetXY;
                    }
                    while(true){
                        if (length != 1){
                            Console.WriteLine("Поворот корабля right(вправо) или down(вниз): ");
                            dir = Console.ReadLine();
                        } else {
                            dir = "right";
                        }
                        if (dir == "right" || dir == ""){
                            for (var i = 0; i < length; i++){
                                if (order.selfMap[x+i, y].ship){
                                    Console.WriteLine("Пересечение с другим кораблём!");
                                    goto GetXY;
                                } else if ((x+length-1) > 10){
                                    Console.WriteLine("Выход за пределы границы");
                                    goto GetXY;
                                }
                            }
                                for (var i = 0; i < length; i++){order.selfMap[x+i, y].ship = true;}
                                break;
                        } else if (dir == "down"){
                            for (var i = 0; i < length; i++){
                                if (order.selfMap[x, y+i].ship){
                                    Console.WriteLine("Пересечение с другим кораблём!");
                                    goto GetXY;
                                } else if ((y+length-1) > 10){
                                    Console.WriteLine("Выход за пределы границы");
                                    goto GetXY;
                                }
                            }
                                for (var i = 0; i < length; i++){order.selfMap[x, y+i].ship = true;}
                                break;
                        }
                    }
                    Console.Clear();
                    renderMaps();
                }
                length--;
            }
        }

        private void playGameStep(){
            switch (gameState){
                case "gameStart": 
                    Player1.enemy = Player2;
                    Player2.enemy = Player1;
                    order = Player1;
                    gameState = "playerNames";
                break;
                case "playerNames": //Игроки пишут имена
                    Console.Write("Имя 1-го игрока: ");
                    Player1.name = Console.ReadLine();
                    Console.Write("Имя 2-го игрока: ");
                    Player2.name = Console.ReadLine();
                    gameState = "arrangingShips";
                    Console.Clear();
                break;
                case "arrangingShips": //Расстановка кораблей
                    Console.Clear();
                    Console.WriteLine("{0} расставляет корабли", order.name);
                    arrangeShip();
                    order = order.enemy;
                    Console.Clear();
                    Console.WriteLine("{0} расставляет корабли", order.name);
                    arrangeShip();
                    order = order.enemy;
                    gameState = "battle";
                    Console.Clear();
                break;
            }
        }

        public void startGame(){
            Console.Clear();
            while (!(gameState == "endGame")){
                playGameStep();
            }
        }
    }
}