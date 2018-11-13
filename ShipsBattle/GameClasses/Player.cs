namespace ShipsBattle
{
    public class Player
    {
        public string name;
        public byte destroyed;
        public Player enemy; 

        public Cell[ , ] selfMap  = new Cell[11, 11];
        public Cell[ , ] enemyMap = new Cell[11, 11];

        public Player(string _name = "Unnamed"){
            name = _name;
            for (var i = 1; i < 11; i++){
                for (var j = 1; j < 11; j++){
                    selfMap[i, j]  = new Cell();
                    enemyMap[i, j] = new Cell();
                }
            }
        }
    }
}