const BaseModule = require('../BaseModule');
const Game = require('./Game');

class GameManager extends BaseModule {
    constructor(options) {
        super(options);
        this.mediator.subscribe(this.EVENTS.ADD_PLAYER, nickname => { 
            if (this.game.addPlayer(nickname)) {
                this.updateScene();
            }
        });
        this.mediator.subscribe(this.EVENTS.DEL_PLAYER, nickname => this.deletePlayer(nickname));
        const sockets = {};
        const SOCKET = options.SOCKET;
        this.SOCKET = SOCKET;

        if (!this.io) { return; }
        this.io.on('connection', socket => { 
            console.log('client connect', socket.id);
            socket.on(SOCKET.START_GAME, (data) => {
                if (data && data.nickname) {
                    const user = this.mediator.get(this.TRIGGERS.GET_USER, data.nickname);
                    if (user) {
                        sockets[socket.id] = user;
                        if (this.game.addPlayer(user.nickname)) {
                            this.updateScene();
                        }
                    }
                }
            });

            socket.on('disconnect', async () => {
                if (sockets[socket.id] && sockets[socket.id].nickname) {
                    this.deletePlayer(sockets[socket.id].nickname);
                    delete sockets[socket.id];
                    console.log('disconnect', socket.id);
                }
            });
        });
    }
}
module.exports = GameManager;