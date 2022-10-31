package co.edu.unipiloto.platVMS.services;

import co.edu.unipiloto.platVMS.entities.Message;
import co.edu.unipiloto.platVMS.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepository msgRepository;

    public List<Message> getAllMessages(){
        return msgRepository.findAll();
    }

    public Message createNewMessage(Message inputMessage){
        return msgRepository.insert(inputMessage);
    }

    public Message updateMessage(Message modifiedMessage){
        Optional<Message> optionalMessage = msgRepository.findById(modifiedMessage.getId());
        if(!optionalMessage.isPresent()){
            return null;
        }
        Message storedMessage = optionalMessage.get();
        storedMessage.setContenido(modifiedMessage.getContenido());
        storedMessage.setId_responsable(modifiedMessage.getId_responsable());
        storedMessage.setFecha_ini(modifiedMessage.getFecha_ini());
        storedMessage.setFecha_fin(modifiedMessage.getFecha_fin());
        msgRepository.insert(storedMessage);
        return storedMessage;
    }

    public String deleteMessage(String msgId){
        msgRepository.deleteById(msgId);
        return "El mensaje " + msgId + " ha sido eliminado";
    }
}
