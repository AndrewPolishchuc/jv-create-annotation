package core.basesyntax.dao.imp;

import core.basesyntax.dao.BetDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.List;

public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.getBets().add(bet);
    }

    @Override
    public List<Bet> getAllBets() {
        return Storage.getBets();
    }
}
