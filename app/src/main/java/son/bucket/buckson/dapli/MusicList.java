String path
path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MUSIC";



File directory = new File(path);
File[] files = directory.listFiles();

List<String> filesNameList = new ArrayList<>();
 
for (int i=0; i< files.length; i++) {
    filesNameList.add(files[i].getName();
}