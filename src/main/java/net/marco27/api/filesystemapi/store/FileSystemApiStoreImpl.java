package net.marco27.api.filesystemapi.store;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.marco27.api.filesystemapi.domain.FileStructure;
import net.marco27.api.filesystemapi.repository.FileStructureCrudRepository;

@Service
public class FileSystemApiStoreImpl implements FileSystemApiStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemApiStoreImpl.class);

    private FileStructureCrudRepository fileStructureCrudRepository;

    public FileSystemApiStoreImpl(@Autowired FileStructureCrudRepository fileStructureCrudRepository) {
        this.fileStructureCrudRepository = fileStructureCrudRepository;
    }

    @Override
    public FileStructure findFileStructureById(final String path) {
        final Optional<FileStructure> result = fileStructureCrudRepository.findById(path);
        return result.orElse(null);
    }

    @Override
    public FileStructure findFileStructureByPath(final String path) {
        return fileStructureCrudRepository.findByPath(path);
    }

    @Override
    public FileStructure saveFileStructure(final FileStructure fileStructure) {
        return fileStructureCrudRepository.save(fileStructure);
    }

    @Override
    public void deleteFileStructure(final FileStructure fileStructure) {
        fileStructureCrudRepository.delete(fileStructure);
    }

}
