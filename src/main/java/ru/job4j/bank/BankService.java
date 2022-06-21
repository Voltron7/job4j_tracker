package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !(users.get(user.get()).contains(account))) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя, если пользователь
     * с таким номером паспорта существует или null
     * если не существует
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет аккаунт пользователя по реквизитам
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты аккаунта
     * @return возвращает аккаунт если аккаунт с такими
     * реквизитами существует или null если не существует
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> u = findByPassport(passport);
            return u.flatMap(user -> users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst());
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
