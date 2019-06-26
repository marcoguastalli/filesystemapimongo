package net.marco27.api.filesystemapi.store;

import net.marco27.api.filesystemapi.configuration.ApplicationConfiguration;
import net.marco27.api.filesystemapi.domain.FileStructure;
import net.marco27.api.filesystemapi.repository.FileStructureCrudRepository;
import net.marco27.api.filesystemapi.repository.FileStructureJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class FileSystemApiStoreImpl implements FileSystemApiStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemApiStoreImpl.class);

    private ApplicationConfiguration applicationConfiguration;
    private FileStructureJpaRepository fileStructureJpaRepository;
    private FileStructureCrudRepository fileStructureCrudRepository;

    public FileSystemApiStoreImpl(@Autowired final ApplicationConfiguration applicationConfiguration,
                                  @Autowired FileStructureJpaRepository fileStructureJpaRepository,
                                  @Autowired FileStructureCrudRepository fileStructureCrudRepository) {
        this.applicationConfiguration = applicationConfiguration;
        this.fileStructureJpaRepository = fileStructureJpaRepository;
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
    public FileStructure savePathStructure(final FileStructure fileStructure) {
        return fileStructureCrudRepository.save(fileStructure);
    }

    @Override
    public void deletePathStructure(final FileStructure fileStructure) {
        fileStructureCrudRepository.delete(fileStructure);
    }

}
