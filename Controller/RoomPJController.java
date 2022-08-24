package com.example.Project.Controller;

import com.example.Project.Service.RoomPJService;
import com.example.Project.dto.ListRoomPJ;
import com.example.Project.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomPJController {
    @Autowired
    RoomPJService roomPJService;
//    ObjectMapper objectMapper = new ObjectMapper();

//    @Autowired
//    FileStorageService fileStorageService;

    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> listAll() {
        List<Room> list = roomPJService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

//    @RequestMapping(value = AppConstants.ROOM_URI,method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public AppResponse createRoom(@RequestParam(value = AppConstants.ROOM_JSON_PARAM,required = true)String empJson,
//                                  @RequestParam(required = true,value = AppConstants.ROOM_JSON_PARAM)MultipartFile file)
//        throws JsonParseException , JsonMappingException , IOException{
//        String fileName = fileStorageService.storeFile(file);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH).path(fileName).toUriString();
//
//        Room room = objectMapper.readValue()
//    }


    //http://localhost:8080/class/save/new
    @RequestMapping(value = "/save/new", method = RequestMethod.POST)
    public ResponseEntity<Room> saveClass(@RequestBody Room tblClass) {
        roomPJService.saveClass(tblClass);
        return ResponseEntity.ok(tblClass);
    }

    //http://localhost:8080/class/update/1
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Room> updateClass(@PathVariable("id") long id,
                                                @RequestBody Room tblClass) {
        Room oldClass = roomPJService.getOne(id);
        if (oldClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldClass.setCategoryid(tblClass.getCategoryid());
            oldClass.setTitle(tblClass.getTitle());
            oldClass.setPrice(tblClass.getPrice());
            oldClass.setThumbnail(tblClass.getThumbnail());
            oldClass.setDescription(tblClass.getDescription());
            oldClass.setAddress(tblClass.getAddress());
            oldClass.setStatus(tblClass.getStatus());
            roomPJService.saveClass(oldClass);
            return ResponseEntity.ok(oldClass);
        }
    }

    //http://localhost:8080/class/delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Room> deleteClass(@PathVariable("id") long id) {
        Optional<Room> tblClass = roomPJService.findRoomById(id);
        if (tblClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            roomPJService.deleteRoom(id);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/lsclass", method = RequestMethod.GET)
    public ResponseEntity<ListRoomPJ> listStudent() {
        List<Room> list = roomPJService.getAll();
        ListRoomPJ ls = new ListRoomPJ();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

//    @RequestMapping(value = "/aroom/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Room> ARoom(@PathVariable("id") long id) {
//        Room list = roomPJService.getOne(id);
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
}
