using System;
using System.Collections.Generic;
using System.Text;

namespace BullsUndCows
{
    class GameLogic
    {
        private int number;
        private int plrNumber;

        public GameLogic()
        {
            number = generateNumber();
        }

        private bool hasSameNumbers(int numb)
        {
            var n = numb.ToString();
            if (!(n[0] != n[1] && n[0] != n[2] && n[0] != n[3]))
            {
                return true;
            }
            else if (!(n[1] != n[2] && n[1] != n[3]))
            {
                return true;
            }
            if (!(n[2] != n[3]))
            {
                return true;
            } else
            {
                return false;
            }
        }

        private int generateNumber()
        {
            int numb;
            do
            {
                Random rnd = new Random();
                numb = 1000 + rnd.Next(8999);
            } while (hasSameNumbers(numb));
            return numb;
        }

        private byte getCows()
        {
            string gameNumb = number.ToString();
            string numb = plrNumber.ToString();
            byte cows = 0;
            for (byte i = 0; i < 4; i++){
                if (gameNumb[i] == numb[i]){
                    ++cows;
                }
            }
            return cows;
        }

        private int getBulls()
        {
            string gameNumb = number.ToString();
            string numb = plrNumber.ToString();
            int bulls = 0;
                if (gameNumb[0] != numb[0]){
                    if (gameNumb[0] == numb[1] || gameNumb[0] == numb[2] || gameNumb[0] == numb[3]){
                        ++bulls;
                    }
                }
                if (gameNumb[1] != numb[1]){
                    if (gameNumb[1] == numb[0] || gameNumb[1] == numb[2] || gameNumb[1] == numb[3]){
                        ++bulls;
                    }
                }
                if (gameNumb[2] != numb[2]){
                    if (gameNumb[2] == numb[0] || gameNumb[2] == numb[1] || gameNumb[2] == numb[3]){
                        ++bulls;
                    }
                }
                if (gameNumb[3] != numb[3]){
                    if (gameNumb[3] == numb[0] || gameNumb[3] == numb[1] || gameNumb[3] == numb[2]){
                        ++bulls;
                    }
                }
            return bulls;
        }

        private bool isWin(){
            if (number == plrNumber){
                return true;
            }
            return false;
        }

        private bool makeStep(){
            if (isWin()){
                Console.WriteLine("Вы угадали число {0}", number);
                return true;
            } else {
                Console.WriteLine("Количество коров: {0}", getCows());
                Console.WriteLine("Количество бычар: {0}", getBulls());
            }
            Console.Write("Ваше число: ");
            plrNumber = Int32.Parse(Console.ReadLine());
            return false;
        }

        public void startGame(){
            Console.Write("Ваше число: ");
            plrNumber = Int32.Parse(Console.ReadLine());
            Console.WriteLine(plrNumber);
            while (true) {
                if (makeStep()){
                    return;
                };
            }
        }
    }
}
