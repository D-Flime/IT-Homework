using System;

namespace ShipsBattle
{
    public class Game
    {
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
                    if (Player1.selfMap[i, j].ship && Player1.selfMap[i, j].shot){
                        Console.SetCursorPosition(ofX+1+i*2, ofY+j);
                        Console.WriteLine("{X}");
                    } else if (Player1.selfMap[i, j].ship){
                        Console.SetCursorPosition(ofX+1+i*2, ofY+j);
                        Console.WriteLine("■");
                    } else if (Player1.selfMap[i, j].shot){
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
                    if (Player1.enemyMap[i, j].ship && Player1.enemyMap[i, j].shot){
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("{X}");
                    } else if (Player1.enemyMap[i, j].ship){
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("■");
                    } else if (Player1.enemyMap[i, j].shot){
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("*");
                    } else {
                        Console.SetCursorPosition(ofX+1+i*2+mn2, ofY+j);
                        Console.WriteLine("~");
                    }
                }
            }
        }

        private void arrangeShip(Player player)
        {
            var x = 0; var y = 0;
            var length = 4;
            var dir = "";
            while (length > 0)
            {
                Console.WriteLine("Введите расположение корабля длины {0}", length);
                GetXY:
                while(true)
                {
                    Console.Write("x: "); x = Convert.ToInt32(Console.ReadLine());
                    if (x > 0 && x < 11 && (x+length-1) < 11){
                        break;
                    }
                    Console.WriteLine("Выход за пределы границы");
                }
                while(true)
                {
                    Console.Write("y: "); y = Convert.ToInt32(Console.ReadLine());
                    if (y > 0 && y < 11 && (y+length-1) < 11){
                        break;
                    }
                    Console.WriteLine("Выход за пределы границы");
                }
                if (Player1.selfMap[x, y].ship){
                    Console.WriteLine("Пересечение с другим кораблём!");
                    goto GetXY;
                }
                while(true){
                    Console.WriteLine("Поворот корабля right(вправо) или down(вниз): ");
                    dir = Console.ReadLine();
                    if (dir == "right" || dir == ""){
                        var error = false;
                        for (var i = 0; i < length; i++){
                            if (player.selfMap[x+i, y].ship){
                                error = true;
                                Console.WriteLine("Пересечение с другим кораблём!");
                                break;
                            }
                        }
                        if (!error){
                            for (var i = 0; i < length; i++){player.selfMap[x+i, y].ship = true;}
                            break;
                        }
                    } else if (dir == "down"){
                        var error = false;
                        for (var i = 0; i < length; i++){
                            if (player.selfMap[x, y+i].ship){
                                error = true;
                                Console.WriteLine("Пересечение с другим кораблём!");
                                break;
                            }
                        }
                        if (!error){
                            for (var i = 0; i < length; i++){player.selfMap[x, y+i].ship = true;}
                            break;
                        }
                    }
                }
                length--;
            }
        }

        private void renderGame(){
            
        }

        public void startGame(){
            Console.Write("Имя 1-го игрока: ");
            Player1.name = Console.ReadLine();
            Console.Write("Имя 2-го игрока: ");
            Player2.name = Console.ReadLine();
            //arrangeShip(Player1);
            Player1 = new Player("Mann");
            Player2 = new Player("Mann2");
            //arrangeShip(Player1);
            arrangeShip(Player1);
            renderMaps();
            
        }
    }
}