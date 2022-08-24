package com.example.Project.view;

import com.example.Project.Service.RoomPJService;
import com.example.Project.model.Room;
import com.example.Project.model.Tenancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class RoomView {
    @Autowired
    RoomPJService roomPJService;

    @GetMapping("/Room")
    public String showHang(Model model){
        List<Room> rooms = roomPJService.getAll();
        model.addAttribute("rooms",rooms);
        return "Room-html";
    }

    @GetMapping("/aroom/{id}")
    public String showdetailRoom(Model model,@PathVariable long id){
        Room room = roomPJService.getOne(id);
        model.addAttribute("rooms",room);
        return "property-agent";
    }

    @GetMapping("/add")
    public String addOrEdit(ModelMap model){
        Room room = new Room();
        model.addAttribute("room",room);
        return "Roomadd";
    }

    @PostMapping(path = "/action")
    public String save11(@Valid Room room, BindingResult result, @RequestParam("thumbnail")MultipartFile myFile){
        room.setThumbnail("_");
        try {
            Path path = Paths.get("src/main/resources/static/uploads/" + myFile.getOriginalFilename());
            Files.write(path,myFile.getBytes());
        } catch (IOException ex){
         ex.printStackTrace();
        }
        room.setThumbnail("/uploads/"+myFile.getOriginalFilename());
        roomPJService.saveClass(room);
        return "redirect:/Room";
    }

    @RequestMapping(path = "/room/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id,
                              Model model) {
        Optional<Room> vehicle = roomPJService.findRoomById(id);
        if (vehicle.isPresent()) {
            model.addAttribute("room", vehicle.get());
            model.addAttribute("category", roomPJService.getAll());
            return "RoomUpdate";
        } else {
            return "";
        }
    }

    @PostMapping("/updateRoom/{id}")
    public String Edit(@Valid Room room, BindingResult result,
                       @PathVariable("id") Long id,
                       @RequestParam("thumbnail")MultipartFile myFile){
        if (!myFile.getOriginalFilename().equals("")){
            try {
                Path path = Paths.get("src/main/resources/static/uploads/" + myFile.getOriginalFilename());
                Files.write(path,myFile.getBytes());
                room.setThumbnail("/uploads/"+myFile.getOriginalFilename());
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        room.setRoomid(id);
        roomPJService.saveClass(room);
        return "redirect:/Room";
    }

}
