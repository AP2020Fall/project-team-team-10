package Model;

import Exception.MediaNotFound;
import Model.Data.Data;
import Model.Tools.AddingNew;
import Model.Tools.Packable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Media implements Packable<Media> {
    private static List<Media> list;
    private long id;
    private String imageSrc;
    private String playerSrc;

    /***************************** getter and setter ***********************************/
    public static List<Media> getList() {
        return list;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getPlayerSrc() {
        return playerSrc;
    }

    public static void setList(List<Media> list) {
        Media.list = list;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void setPlayerSrc(String playerSrc) {
        this.playerSrc = playerSrc;
    }


    /****************************** add and remove ***********************/
    public static void addMedia(@NotNull Media media) {
        media.setId(AddingNew.getRegisteringId().apply(list));
        list.add(media);
        Database.save(media, true);
    }

    public static void removeMedia(Media media) {
        list.removeIf(productMediaPrime -> productMediaPrime.getId() == media.getId());
        Database.remove(media);
    }

    public static Media getMediasById(long id) throws MediaNotFound {
        return list.stream()
                .filter(productMedia -> id == productMedia.getId())
                .findFirst()
                .orElseThrow(() -> new MediaNotFound("Medias with id:" + id + " not found."));
    }

    /*************************** pack ***************************************/
    @Override
    public Data<Media> pack() {
        return new Data<Media>()
                .addField(id)
                .addField(imageSrc)
                .addField(playerSrc)
                .setInstance(new Media());
    }

    @Override
    public Media dpkg(@NotNull Data<Media> data) {
        this.id = (long) data.getFields().get(0);
        this.imageSrc = (String) data.getFields().get(1);
        this.playerSrc = (String) data.getFields().get(2);
        return this;
    }
}
