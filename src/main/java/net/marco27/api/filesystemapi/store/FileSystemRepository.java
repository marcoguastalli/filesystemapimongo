package net.marco27.api.filesystemapi.store;

import net.marco27.api.filesystemapi.domain.FileStructure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileSystemRepository extends MongoRepository<FileStructure, String> {

    FileStructure findByPath(final String path);

}
