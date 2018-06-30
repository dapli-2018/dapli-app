package son.bucket.buckson.dapli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MusicListIDTask {
    private static final String ID_FILE_PATH = "./IDList.memo";
    private static final int MAX_ID_NUM = 9999;
    private static int size=-1;
    // read ID list
    public static int[] load_local_id_list_file() throws IOException {
        int[] local_id_list = new int[MAX_ID_NUM];
        BufferedReader buf_reader = new BufferedReader(new FileReader(ID_FILE_PATH));
        String id_list_str = buf_reader.readLine();
        String[] id_str_list = null;
        size = 0;

        // There`s no ID
        if( id_list_str == null) return null;

        id_str_list = id_list_str.split(" ");
        for( String id_str : id_str_list)
            if( !id_str.equals("0"))
                local_id_list[size++] = Integer.parseInt(id_str);

        buf_reader.close();
        return local_id_list;
    }

    // write ID (append)
    public static void add_local_id(int _id) throws IOException {
        PrintWriter prt_writer = new PrintWriter(new FileWriter(ID_FILE_PATH, true));
        prt_writer.print(" ");
        prt_writer.print(_id);
        prt_writer.close();
    }

    // remove ID (rewrite)
    public static void remove_local_id(int _id) throws IOException {
        PrintWriter prt_writer = new PrintWriter(new FileWriter(ID_FILE_PATH, true));
        int[] id_list = load_local_id_list_file();
        boolean flag = false;

        for(int id : id_list){
            if( id != _id) {
                if (!flag) flag = true;
                else prt_writer.print(" ");
                prt_writer.print(id);
            }
        }

        prt_writer.close();
    }
}
