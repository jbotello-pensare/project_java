package mx.pensare.jamie.demo.controllers;

import lombok.RequiredArgsConstructor;
import mx.pensare.jamie.demo.controllers.dtos.OpenAccountRequest;
import mx.pensare.jamie.demo.controllers.dtos.OpenTransferRequest;
import mx.pensare.jamie.demo.persistance.Account;
import mx.pensare.jamie.demo.persistance.AccountRepository;
import mx.pensare.jamie.demo.persistance.Transfer;
import mx.pensare.jamie.demo.persistance.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private String valorAccount;
    private Account valorSource;
    private Double source_balance;
    private Double new_balance;
    private String valorDestination;
    private Long valor_id;
    private Long destination_id;
    private Account valorDestinatioNumber;
    private Double destination_balance;
    private Double new_destination_balance;
    private String message;


    @Autowired
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @GetMapping()
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping()
    public Account openAccount(@Valid @RequestBody()OpenAccountRequest openAccountRequest){
        UUID uuid = UUID.randomUUID();
        Account account = Account.builder()
                .name(openAccountRequest.getName())
                .number(uuid.toString())
                .balance(0.0)
                .build();
        account = accountRepository.save(account);
        return account;
    }

    @PostMapping("/transfer")
    public Transfer openTransfer(@RequestBody()OpenTransferRequest openTransferRequest){
        Transfer transfer = Transfer.builder()
                .sourceAccount(openTransferRequest.getSourceAccount())
                .destinationAccount(openTransferRequest.getDestinationAccount())
                .concept(openTransferRequest.getConcept())
                .amount(openTransferRequest.getAmount())
                .build();
        transfer = transferRepository.save(transfer);
        valorAccount = transfer.getSourceAccount().getNumber();
        valorDestination = transfer.getDestinationAccount();
        valorSource = accountRepository.findByNumber(valorAccount);
        valorDestinatioNumber = accountRepository.findByNumber(valorDestination);
        source_balance = valorSource.getBalance();
        destination_balance = valorDestinatioNumber.getBalance();
        if(source_balance > transfer.getAmount()){
            new_balance = source_balance - transfer.getAmount();
            new_destination_balance = destination_balance + transfer.getAmount();
            valor_id = valorSource.getId();
            destination_id = valorDestinatioNumber.getId();
            accountRepository.updateOne(new_balance, valor_id);
            accountRepository.updateOne(new_destination_balance,destination_id);
            message = "successful transaction";
            System.out.print(message);

        } else{
            message = "The transfer couldn't be made,your balance is insufficient";
            System.out.print(message);
        }
        return transfer;
    }

}
