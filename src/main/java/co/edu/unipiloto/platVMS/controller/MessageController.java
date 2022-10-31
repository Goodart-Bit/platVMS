package co.edu.unipiloto.platVMS.controller;

import co.edu.unipiloto.platVMS.entities.Message;
import co.edu.unipiloto.platVMS.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "mensaje/")
public class MessageController {
    @Autowired
    private MessageService msgService;

    @GetMapping(value = "/get")
    public List<Message> getAllMessages(){
        return msgService.getAllMessages();
    }

    @PostMapping(value = "/addMessage")
    public Message addMessage(@RequestBody Message message){
        return msgService.createNewMessage(message);
    }

    @PutMapping(value = "/editMessage")
    public Message updateMessage(Message message){
        return msgService.updateMessage(message);
    }

    @DeleteMapping(value="/delMessage/{id}")
    public String deleteMessageById(@PathVariable String id){
        return msgService.deleteMessage(id);
    }

}
