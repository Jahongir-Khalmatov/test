package lesson4.click.service;

import lesson4.click.entity.Card;
import lesson4.click.repository.CardRepository;
import lesson4.click.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    JwtProvider jwtProvider;

    public List<Card> getList(){
        return cardRepository.findAll();
    }
    public Card getById(Integer id){
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (!optionalCard.isPresent())
            return null;
        Card card = optionalCard.get();
        return card;
    }
    public HttpEntity<?> add(Card card, HttpServletRequest request) {
        boolean exists = cardRepository.existsByNumber(card.getNumber());
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This card number already exists");
        }
        Card card1 = new Card();
        String authorization = jwtProvider.getUsernameFromToken(request.getHeader("Authorization"));
        card1.setUserName(authorization);

        card1.setNumber(card.getNumber());
        card1.setExpiredDate(card.getExpiredDate());
        cardRepository.save(card1);
       return ResponseEntity.status(201).body("Added");
    }
    public HttpEntity<?> edit(Integer id,Card card,HttpServletRequest request){
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (!optionalCard.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card Id not founded");
        Card card1 = optionalCard.get();
        String authorization = jwtProvider.getUsernameFromToken(request.getHeader("Authorization"));
        card1.setUserName(authorization);

        card1.setNumber(card.getNumber());
        card1.setExpiredDate(card.getExpiredDate());
        cardRepository.save(card1);
        return ResponseEntity.status(201).body("Edited");

    }
    public HttpEntity<?> delete(Integer id){
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (!optionalCard.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card Id not founded");
        Card card = optionalCard.get();
        card.setActive(false);
        return ResponseEntity.ok().body("DisActivated");
    }
}
