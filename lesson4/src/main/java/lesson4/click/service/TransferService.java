package lesson4.click.service;

import lesson4.click.entity.Card;
import lesson4.click.payload.TransferDto;
import lesson4.click.repository.CardRepository;
import lesson4.click.repository.IncomeRepository;
import lesson4.click.repository.OutcomeRepository;
import lesson4.click.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class TransferService {
@Autowired
    CardRepository cardRepository;
@Autowired
    IncomeRepository incomeRepository;
@Autowired
    OutcomeRepository outcomeRepository;
@Autowired
    JwtProvider jwtProvider;
double total=0;

public HttpEntity<?> sendMoney(TransferDto transferDto, HttpServletRequest request){
    String token = request.getHeader(("Authorization"));
    String username = jwtProvider.getUsernameFromToken(token);

    Optional<Card> optionalFromCard = cardRepository.findByNumber(transferDto.getFromCardId());
    Optional<Card> optionalToCard = cardRepository.findByNumber(transferDto.getToCardId());
    if (!optionalFromCard.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sending Card id not founded");
    }
    if (!optionalToCard.isPresent()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sending Card id not founded");
    }
    if (optionalFromCard==optionalToCard){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("The card Numbers are similar");
    }
    Card toCard = optionalToCard.get();
    Card fromCard = optionalFromCard.get();
    if (!fromCard.getUserName().equals(username)&&!toCard.getUserName().equals(username)) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Card is not yours");
    }
    Double balance = fromCard.getBalance();
    Double amount = transferDto.getAmount();
    Double commissionAmount=amount*0.01;
    double total=commissionAmount+amount;
    Double balance1 = toCard.getBalance();
    if (total>balance){
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("The money does not enough to transfer");
}
    fromCard.setBalance(balance-total);
    toCard.setBalance(balance1+amount);
    cardRepository.save(fromCard);
    cardRepository.save(toCard);
return     ResponseEntity.status(201).body("Transferd");

    




}
}
