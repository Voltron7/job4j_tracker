package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского перевода, испльзуя
 * номер паспорта и реквизиты счета
 * @author Valeri Shpakowski
 * @version 1.0
 */

public class BankService {

    /**
     * Поле хранит всех пользователей с привязанными к ним
     * аккаунтами в коллеции типа HashMap
     */

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его
     * @param user пользователь добавленный в систему
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый аккаунт пользователю если
     * у пользователя еще нет счета
     * @param passport номер паспорта пользователя
     * @param account аккаунт пользователя
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя, если пользователь
     * с таким номером паспорта существует или null
     * если не существует
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет аккаунт пользователя по реквизитам
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты аккаунта
     * @return возвращает аккаунт если аккаунт с такими
     * реквизитами существует или null если не существует
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит денежные средства с одного счета на другой
     * @param srcPassport номер паспорта пользователя со счета
     *                    которого будут переведены средства
     * @param srcRequisite реквизиты счета с которого будет
     *                     осуществлен перевод средств
     * @param destPassport номер паспорта пользователя на счет
     *                     которого будут зачислены средства
     * @param destRequisite реквизиты счета на который будут
     *                      зачислены средства
     * @param amount сумма денежных средств
     * @return вернет true, если средства будут зачислены на
     * счет успешно или false если нет по причине того, что либо
     * счет не существует либо не хватает средств на счете с
     * которого была осуществлена попытка перевода средств
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
