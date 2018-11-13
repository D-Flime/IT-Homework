namespace ShipsBattle
{
    public class Cell
    {
        public bool shot;
        public bool ship;

        public Cell(){
            ship = false;
            shot = false;
        }

        public Cell(bool _ship)
        {
            shot = false;
            if (_ship)
            {
                ship = true;
            }
        }
    }
}