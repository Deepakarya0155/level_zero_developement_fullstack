package com.backend.controllers;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class TestDo {

	@NonNull
	String name;
	@NonNull
	Long age;
}
