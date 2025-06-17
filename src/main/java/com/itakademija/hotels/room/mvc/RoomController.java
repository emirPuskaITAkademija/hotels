package com.itakademija.hotels.room.mvc;

import com.itakademija.hotels.room.Room;
import com.itakademija.hotels.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Model View Controller
//VIEW - html
//MODEL - su podaci
//CONTROLLER - je onaj ko dovuče podatke iz baze i u baci ih u model. Zašto on to radi ?
// On to uradi kako bi view(html) mogao pristupiti room podatku
@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/addRoom")
    public String showAddRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "add_room";
    }

    @GetMapping("/rooms")
    public String showRooms(Model model) {
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms_view";
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@ModelAttribute("room") Room room) {
        try {
            roomRepository.save(room);
            return "redirect:/rooms";
        }catch (Exception e){
            return "redirect:/addRoom";
        }
    }
}
