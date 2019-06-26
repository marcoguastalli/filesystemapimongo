package net.marco27.api.filesystemapi.store;

import net.marco27.api.filesystemapi.domain.FileStructure;

public interface FileSystemApiStore {

    FileStructure findFileStructureById(String path);

    FileStructure findFileStructureByPath(String path);

    FileStructure savePathStructure(FileStructure fileStructure);

    void deletePathStructure(FileStructure fileStructure);

}
